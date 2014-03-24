package de.cubeisland.maven.plugins.messageextractor.format;

import java.io.File;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public abstract class AbstractCatalogConfiguration implements CatalogConfiguration
{
    @XmlElement(name = "template", required = true)
    protected File templateFile;

    @XmlElement
    protected boolean removeUnusedMessages = true;

    @XmlElement
    protected boolean createEmptyTemplate = false;

    @XmlAttribute(name = "charset")
    protected String charsetName;

    public final File getTemplateFile()
    {
        return this.templateFile;
    }

    public final boolean getRemoveUnusedMessages()
    {
        return this.removeUnusedMessages;
    }

    public final boolean getCreateEmptyTemplate()
    {
        return this.createEmptyTemplate;
    }

    public String getCharsetName()
    {
        return this.charsetName;
    }
}
