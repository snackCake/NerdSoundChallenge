package com.nerdery.soundchallenge.services;

import com.nerdery.soundchallenge.services.midigenerators.MidiGenerator;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.inject.Inject;
import javax.sound.midi.InvalidMidiDataException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Service
public class MidiService {

    private Map<String, MidiGenerator> generators;

    @Inject
    public MidiService(List<MidiGenerator> filters) {
        this.generators = filters.stream().collect(Collectors.toMap(MidiGenerator::getName, Function.identity()));
    }

    public void generateSong(OutputStream outputStream, String filterName) throws IOException, InvalidMidiDataException {
        Assert.notNull(outputStream);
        Assert.notNull(filterName);
        Assert.isTrue(isValidGenerator(filterName));
        generators.get(filterName).generateSong(outputStream);
    }

    public boolean isValidGenerator(String filterName) {
        return generators.containsKey(filterName);
    }
}
