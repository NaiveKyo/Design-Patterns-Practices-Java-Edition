package io.naivekyo.structural.Facade.facede;

import io.naivekyo.structural.Facade.subsystem.VideoFile;

/**
 * Facade 类: 屏蔽内部利用多个子系统进行复杂的处理, 对外暴露特定的接口; <br/>
 * 这些接口并不会包含子系统所能提供的所有功能, 而是提供用户关心的接口, 后续可以继续添加相关接口, 或者重写外观类;
 */
public class VideoConverter {
    
    public VideoFile converter(String fileName, String format) {
        VideoFile file = new VideoFile(fileName);
        
        // ........
        
        return null;
    }
}
