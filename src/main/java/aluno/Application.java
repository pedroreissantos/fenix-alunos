package aluno;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import pt.ist.fenixframework.FenixFramework;

public class Application {

	// FenixFramework will try automatic initialization when first accessed
	public static void main(String [] cmds) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while ((line = readline(reader, ". ")) != null) {
				if (line.length() == 0) {
					System.out.println("USAGE:\n+ code name (add)\n- code (remove)\n= code (get)\n? code (find by regex)\n* (list all)\n$ (delete all)\nq (exit)");
					continue;
				}
				String[] args = line.split(" ", 3);
				if (args[0].charAt(0) == 'q') break;
				switch (args[0].charAt(0)) {
					case '+':
						System.out.println("#"+args.length);
						if (args.length == 3)
							AtomicInterface.add(args[1], args[2]);
						break;
					case '-':
						if (args.length == 2)
							AtomicInterface.remove(args[1]);
						break;
					case '=':
						if (args.length == 2)
							AtomicInterface.get(args[1]);
						break;
					case '*':
						AtomicInterface.list();
						break;
					case '$':
						AtomicInterface.deleteAll();
						break;
					case '?':
						if (args.length == 2)
							AtomicInterface.find(args[1]);
						break;
				}
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		} finally {
			FenixFramework.shutdown(); // ensure an orderly shutdown
		}
	}

	private static String readline(BufferedReader reader, String prompt) throws IOException {
		System.out.print(prompt);
		return reader.readLine();
	}
}
