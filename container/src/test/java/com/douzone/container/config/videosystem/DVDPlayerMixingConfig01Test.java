package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.config.videosystem.mixing.DVDPlayerConfig;
import com.douzone.container.videosystem.DVDPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DVDPlayerConfig.class)
public class DVDPlayerMixingConfig01Test {

	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private DVDPlayer player;
	
	@Test
	public void testPlayer() {
		assertNotNull(player);
		player.play();
		assertEquals("Playing Movie MARVEL's Avengers Infinity War", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}
