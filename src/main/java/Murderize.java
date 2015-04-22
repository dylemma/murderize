import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Murderize {

	public final static int MISSING_ARGS = 1;
	public final static int NONEXISTANT_TARGET = 2;
	public final static int TOO_MANY_ARGS = 3;
	public final static int IO_EXCEPTION = 4;

	public static void println(String line){
		// just a shortcut
		System.out.println(line);
	}

	public static void main(String[] args){
		if(args.length == 0){
			println("Specify the directory or file to delete");
			System.exit(MISSING_ARGS);
		} else if(args.length == 1){
			String path = args[0];
			File toDelete = new File(path);
			try {
				boolean done = murderize(toDelete);
				if(done){
					println("Murderization success.");
					System.exit(0);
				} else {
					println("I can't murderize " + path + " because it doesn't exist");
					System.exit(NONEXISTANT_TARGET);
				}
			} catch (IOException e){
				println("Murerization error: " + e.getMessage());
				System.exit(IO_EXCEPTION);
			}
		} else {
			println("Expected 1 argument, but saw " + args.length);
			System.exit(TOO_MANY_ARGS);
		}
	}

	public static boolean murderize(File toDelete) throws IOException {
		if(toDelete.exists()){
			println("I'm going to murderize " + toDelete);
			if(toDelete.isDirectory()) FileUtils.deleteDirectory(toDelete);
			else toDelete.delete();
			return true;
		} else {
			return false;
		}
	}
}