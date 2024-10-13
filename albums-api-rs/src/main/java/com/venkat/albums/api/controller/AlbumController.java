package com.venkat.albums.api.controller;

import com.venkat.albums.api.model.AlbumResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @GetMapping
    public List<AlbumResponse> getAlbums(){
        AlbumResponse albumResponse = new AlbumResponse();
        albumResponse.setAlbumId("1");
        albumResponse.setUserId("1");
        albumResponse.setTitle("some title");
        albumResponse.setDescription("some description");
        albumResponse.setUrl("some url");
        return List.of(albumResponse);
    }
}
