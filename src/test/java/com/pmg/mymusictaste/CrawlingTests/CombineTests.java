package com.pmg.mymusictaste.CrawlingTests;

import com.pmg.mymusictaste.Scheduler.AutoCrawl;
import com.pmg.mymusictaste.service.SongService;
import com.pmg.mymusictaste.service.SongServiceImpl;
import com.pmg.mymusictaste.util.MelonTarget;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class CombineTests {

    @Setter(onMethod_ = { @Autowired })
    private SongService sServ;

    @Test
    public void autoCrawlTest() {

      
        // AutoCrawl.startCrawling(MelonTarget.DAILY);
        // sServ.saveSongList(AutoCrawl.startCrawling(MelonTarget.MONTHLY));
        // sServ.saveSongList(AutoCrawl.startCrawling(MelonTarget.REALTIME));
        // sServ.saveSongList(AutoCrawl.startCrawling(MelonTarget.WEEKLY));
    }

 }
