package com.nerdery.soundchallenge.controllers;

import com.nerdery.soundchallenge.models.MidiGeneratorEntry;
import com.nerdery.soundchallenge.services.MidiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Controller
public class MidiController {

    public static final String MIDI_MIME_TYPE = "application/x-midi";
    private MidiService midiService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getIndex(Model model) {
//        Stream<MidiGeneratorEntry> midiGenerators = midiService.getGenerators().stream().map((generator) ->
//                new MidiGeneratorEntry(generator.getName(), String.format("/midi/%s.mid", generator.getName())));
//
//        model.addAttribute("generators", midiGenerators.collect(Collectors.toList()));
//        return "index";
//    }

    @RequestMapping(value = "/midi/{name}.mid", method = RequestMethod.GET)
    public void getMidiFile(@PathVariable("name") String filterName, HttpServletResponse response)
            throws IOException, InvalidMidiDataException {
        if (midiService.isValidGenerator(filterName)) {
            try (OutputStream responseStream = response.getOutputStream()) {
                response.setContentType(MIDI_MIME_TYPE);
                midiService.generateSong(responseStream, filterName);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid MIDI generator");
        }
    }

    @Inject
    public void setMidiService(MidiService theMidiService) {
        midiService = theMidiService;
    }
}
