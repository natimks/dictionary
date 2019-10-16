import java.io.File;

import de.tudarmstadt.ukp.jwktl.JWKTL;
import de.tudarmstadt.ukp.jwktl.api.IWiktionaryEdition;
import de.tudarmstadt.ukp.jwktl.api.IWiktionaryEntry;
import de.tudarmstadt.ukp.jwktl.api.IWiktionaryPage;
import de.tudarmstadt.ukp.jwktl.api.IWiktionaryTranslation;
import de.tudarmstadt.ukp.jwktl.api.PartOfSpeech;
import de.tudarmstadt.ukp.jwktl.api.util.Language;

public class TranslationTest {
	private static File fileWiki;
	private static final String WIKI_DIR = "/home/aluno/eclipse-workspace/Dicionario/res";

	public static void main(String[] args) {
		fileWiki = new File(WIKI_DIR);
		IWiktionaryEdition wkt = JWKTL.openEdition(fileWiki);
		IWiktionaryPage page = wkt.getPageForWord("dog");
		for (IWiktionaryEntry entry : page.getEntries())
			if (entry.getPartOfSpeech() == PartOfSpeech.NOUN)
				for (IWiktionaryTranslation translation : entry.getTranslations(Language.GERMAN))
					System.out.println(translation.getTranslation());
		wkt.close();
	}
}
