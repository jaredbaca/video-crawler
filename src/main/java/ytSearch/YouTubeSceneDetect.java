package ytSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import edu.bu.met622.finalproject.Constants;


/**
 * This class calls the YouTube scene detect shell script via the Java ProcessBuilder class.
 * @author jbaca
 *
 */
public class YouTubeSceneDetect implements Constants{
	
public void detectScenes() throws IOException {
		
		String[] commands = {SHELL, YT_SCENE_DETECT};
		ProcessBuilder pb = new ProcessBuilder(commands);
		Map<String, String> env = pb.environment();
		env.put("PATH", "/usr/local/bin");
		pb.directory(WORKING_DIRECTORY);
		pb.redirectErrorStream(true);
		pb.redirectOutput();
		pb.redirectInput();
		Process p = pb.start();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while((line = reader.readLine()) != null ) {
			System.out.println(line);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
