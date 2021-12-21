package dev.mruniverse.slimereports;

import dev.mruniverse.guardianstorageapi.interfaces.GuardianFiles;

public enum SlimeFiles implements GuardianFiles {
    SETTINGS {
        @Override
        public String getFileName() {
            return "settings.yml";
        }
        @Override
        public String getFolderName() {
            return "";
        }
        @Override
        public boolean isInDifferentFolder() {
            return false;
        }
    },
    REPORTS {
        @Override
        public String getFileName() {
            return "reports.yml";
        }
        @Override
        public String getFolderName() {
            return "";
        }
        @Override
        public boolean isInDifferentFolder() {
            return false;
        }
    }
}
