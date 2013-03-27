package de.cubeisland.cubeengine.util.gettextgen.mojo;

import de.cubeisland.cubeengine.util.gettextgen.format.*;
import de.cubeisland.cubeengine.util.gettextgen.parser.*;
import org.apache.maven.plugin.*;

import java.io.*;
import java.util.*;

/**
 * Blabla
 *
 * @goal generate
 */
public class GenerateMojo extends AbstractMessageCatalogMojo
{
    @Override
    public void doExecute() throws MojoExecutionException, MojoFailureException
    {
        SourceParser parser = SourceParserFactory.newSourceParser(this.language, this.config, this.getLog());
        Set<TranslatableMessage> messages = parser.parse (this.sourcePath);

        CatalogFormat catalogFormat = CatalogFormatFactory.newCatalogFormat(this.outputFormat, config, this.getLog());
        File file = new File(this.templateFile + "." + catalogFormat.getFileExtension());
        try
        {
            catalogFormat.write(file, messages);
        }
        catch (IOException e)
        {
            throw new MojoExecutionException("Failed to write the message catalog.", e);
        }
    }
}
