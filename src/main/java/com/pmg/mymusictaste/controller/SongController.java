package com.pmg.mymusictaste.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.service.PlayingService;
import com.pmg.mymusictaste.service.SongService;
import com.pmg.mymusictaste.util.MelonTarget;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController  
@RequestMapping("/*")
@RequiredArgsConstructor
@CrossOrigin
public class SongController {

    private final SongService songServ;
    private final PlayingService playServ;

    // 실시간/일간/주간/월간 별로 리스트 데이터를 반환
    @GetMapping("/musicChartList/{type}/{page}")
    public ResponseEntity<Page<Song>> getSongList(@PathVariable MelonTarget type, @PathVariable Integer page) {
        Page<Song> songList = songServ.getSongListByType(page,100,type); 
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

/*     @PostMapping("/playList")
    public ResponseEntity<List<Playing>> addMusic(@RequestBody List<Long> sids, @SessionAttribute("user") SessionMember user){
        List<Playing> playList = new ArrayList<>();
        Member member = memServ.findByEmail(user.getEmail());
        for(Long sid : sids) {
            Song song = songServ.getSongById(sid);
            playList.add(Playing.builder()
            .title(song.getTitle())
            .singer(song.getSinger())
            .youtubeid(song.getYoutubeId())
            .member(member).build());
        }
        playServ.addMusic(playList);
        return new ResponseEntity<>(playList,HttpStatus.OK);
    } */
/* 
    @GetMapping("/playList")
    public ResponseEntity<List<Playing>> getPlayList(@SessionAttribute("user") SessionMember user){
        return new ResponseEntity<>(playServ.getMemberPlayList(memServ.findByEmail(user.getEmail())),HttpStatus.OK);
    } */

    @DeleteMapping("/playList")
    public void deletePlayList(@RequestBody List<Long> pids){
        playServ.deletePlayingList(pids);
    }

    
    @GetMapping("/serverTime")
    public ResponseEntity<LocalDateTime> getServerTime(){
        return new ResponseEntity<>(LocalDateTime.now(),HttpStatus.OK);
    }
    
  }

    

