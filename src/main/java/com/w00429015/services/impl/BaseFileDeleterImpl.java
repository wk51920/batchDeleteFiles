package com.w00429015.services.impl;

import com.w00429015.services.FileDeleter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @program: batchDeleteFiles
 * @description: 文件删除基类
 * @author: wk
 * @create: 2018-06-18 18:38
 **/
@Component
public class BaseFileDeleterImpl implements FileDeleter {

    private @Value
   ("${dirPaths}") String dirPathStr;

    @Override
    public void deleteFiles() {
        Path dirPath =  Paths.get(this.dirPathStr);
        long startTime = System.currentTimeMillis();
        try {
            Files.walkFileTree(dirPath, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.format("Delete all files takes %ds", (endTime-endTime)/1000);
    }
}
