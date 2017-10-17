package ua.goit.java.startup.translator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import ua.goit.java.startup.bom.Startup;
import ua.goit.java.startup.dto.StartupDto;

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class StartupTranslatorTest {

    private static final String NAME = "Name";
    private static final String DESCRIPTION = "Description";
    private static final Long COST = 100L;
    private static final Long CURRENTSUM = 1000L;

    @Spy
    @InjectMocks
    private StartupTranslator startupTranslator;

    @Test
    public void testToDto(){
        Startup startup = new Startup();
        startup.setCost(COST);
        StartupDto startupDto = startupTranslator.toDto(startup);
        Assert.assertEquals(startupDto.getCost(), startup.getCost());
    }

    @Test
    public void testFromDto(){
        StartupDto startupDto = new StartupDto();
        startupDto.setCost(COST);
        Startup startup = startupTranslator.fromDto(startupDto);
        Assert.assertEquals(startup.getCost(), startupDto.getCost());
    }

    @Test
    public void testGetStartupListFromDto() {
        StartupDto startupDto = new StartupDto();
        startupDto.setName(NAME);
        startupDto.setDescription(DESCRIPTION);
        startupDto.setCost(COST);
        startupDto.setCurrentSum(CURRENTSUM);
        Set<StartupDto> startupDtoSet = new HashSet<>();
        startupDtoSet.add(startupDto);
        Set<Startup> startups = startupTranslator.getListFromDto(startupDtoSet);
        Startup element = startups.iterator().next();
        Assert.assertEquals(element.getName(),startupDto.getName());
        Assert.assertEquals(element.getDescription(),startupDto.getDescription());
        Assert.assertEquals(element.getCost(),startupDto.getCost());
        Assert.assertEquals(element.getCurrentSum(),startupDto.getCurrentSum());
        Assert.assertTrue(element instanceof Startup);
    }
}