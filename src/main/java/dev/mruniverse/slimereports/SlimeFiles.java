package dev.mruniverse.slimereports;

import dev.mruniverse.guardianstorageapi.interfaces.GuardianFiles;

public enum SlimeFiles implements GuardianFiles {
    SETTINGS("settings.yml","",false),
    REPORTS("reports.yml","",false);

    private final String file;

    private final String folder;

    private final boolean differentFolder;

    SlimeFiles(String file,String folder,boolean differentFolder) {
        this.file = file;
        this.folder = folder;
        this.differentFolder = differentFolder;
    }

    @Override
    public boolean isInDifferentFolder() {
        return this.differentFolder;
    }

    @Override
    public String getFileName() {
        return this.file;
    }

    @Override
    public String getFolderName() {
        return this.folder;
    }
}
