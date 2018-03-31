package com.zoox.sample.git.integration;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.spring.SpringStepsFactory;

import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Arrays;

import static org.jbehave.core.reporters.Format.*;

public abstract class AbstractStory extends JUnitStory {

    private static final int STORY_TIMEOUT = 120;

    @Resource
    private ApplicationContext applicationContext;

    AbstractStory() {
        Embedder embedder = new Embedder();
        embedder.useEmbedderControls(embedderControls());
        embedder.useMetaFilters(Arrays.asList("-skip"));
        useEmbedder(embedder);
    }

    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryPathResolver(storyPathResolver())
                .useStoryLoader(storyLoader())
                .useStoryReporterBuilder(storyReporterBuilder())
                .useParameterControls(parameterControls());
    }


    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(), applicationContext);
    }

    private EmbedderControls embedderControls() {
        return new EmbedderControls()
                .doIgnoreFailureInView(true)
                .useStoryTimeoutInSecs(STORY_TIMEOUT);
    }

    private ParameterControls parameterControls() {
        return new ParameterControls()
                .useDelimiterNamedParameters(true);
    }

    private StoryPathResolver storyPathResolver() {
        return new UnderscoredCamelCaseResolver();
    }

    private StoryLoader storyLoader() {
        return new LoadFromClasspath();
    }

    private StoryReporterBuilder storyReporterBuilder() {
        return new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
                .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                .withFailureTrace(true)
                .withDefaultFormats()
                .withFormats(IDE_CONSOLE, TXT, HTML);
    }
}