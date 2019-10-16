import java.io.File;

import de.tudarmstadt.ukp.jwktl.JWKTL;

public class ParserData {
	public static void main(String[] args) throws Exception {
		  File dumpFile = new File("/home/aluno/eclipse-workspace/Dicionario/dewiktionary-20141224-pages-articles.xml");
		  File outputDirectory = new File("/home/aluno/eclipse-workspace/Dicionario/res");
		  boolean overwriteExisting = true;
		    
		  JWKTL.parseWiktionaryDump(dumpFile, outputDirectory, overwriteExisting);
		}
}
