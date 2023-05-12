package com.example.firstproject.mapper;

import com.example.firstproject.domain.Anime;
import com.example.firstproject.requests.AnimePostRequestBody;
import com.example.firstproject.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
