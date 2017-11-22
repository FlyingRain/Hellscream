package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.model.Audio;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 4/12/17.
 */
public interface AudioMapper {

    @Insert("insert into audio (word_id,channel_audio_address,audio_address,audio_type) values" +
            "   (#{audio.word_id},#{audio.channel_audio_address},#{audio.audio_address},#{audio.audio_type})")
    int saveAudio(@Param("audio") Audio audio);


    @Select("select * from audio where word_id=#{wordId} and audio_type=#{type}")
    Audio getAudioByWordIdAndType(@Param("wordId") int wordId, @Param("type") String type);

    /**
     * 获取单词发音
     * @param wordId
     * @return
     */
    @Select("select * from audio where word_id={#wordId}")
    List<Audio> wordAudios(int wordId);
}
