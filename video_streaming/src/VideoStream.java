//VideoStream

import java.io.*;
import java.nio.file.*;

public class VideoStream {
  FileInputStream fis; //video file
  int frame_nb; //current frame nb
  String videoFolder = "video";
  //-----------------------------------
  //constructor
  //-----------------------------------
  public VideoStream(String filename) throws Exception{
    //init variables
    Path filePath = Paths.get(videoFolder, filename);
    fis = new FileInputStream(filePath.toString());
    frame_nb = 0;
  }

  //-----------------------------------
  // getnextframe
  //returns the next frame as an array of byte and the size of the frame
  //-----------------------------------
  public int getnextframe(byte[] frame) throws Exception
  {
    int length = 0;
    String length_string;
    byte[] frame_length = new byte[5];

    //read current frame length
    fis.read(frame_length,0,5);

    //transform frame_length to integer
    length_string = new String(frame_length);
    length = Integer.parseInt(length_string);

    return(fis.read(frame,0,length));
  }
}