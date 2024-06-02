import java.io.IOException;
public class Main
{
    public static void main(String[] args)
    {
        String mp3FilePath = "C:/Users/tonih/IdeaProjects/MP3GtoMP4Conversion/example2.mp3";
        String cdgFilePath = "C:/Users/tonih/IdeaProjects/MP3GtoMP4Conversion/example2.cdg";
        String mp4OutputPath = "C:/Users/tonih/IdeaProjects/MP3GtoMP4Conversion/output2.mp4";

        try
        {
                String[] command = {
                        "C:/Users/tonih/IdeaProjects/MP3GtoMP4Conversion/ffmpeg/ffmpeg-2024-02-19-git-0c8e64e268-full_build/bin/ffmpeg.exe",
                        "-i", mp3FilePath,       // Input MP3 file
                        "-i", cdgFilePath,       // Input CDG file
                        "-c:v", "libx264",       // Video codec
                        "-vf", "format=yuv420p", // Video filter for pixel format
                        "-c:a", "aac",           // Audio codec
                        "-b:a", "320k",          // Audio bitrate
                        "-shortest", "-y",            // Stop when the shortest stream ends
                        mp4OutputPath            // Output MP4 file
                };

            ProcessBuilder pb = new ProcessBuilder(command);

            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);

            Process process = pb.start();

            process.waitFor();

            System.out.println("MP4 file created successfully: " + mp4OutputPath);
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}