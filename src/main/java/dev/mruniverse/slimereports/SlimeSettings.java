package dev.mruniverse.slimereports;

@SuppressWarnings("unused")
public enum SlimeSettings implements SlimeSetting {
    BAN_EVADING_ENABLED {
        @Override
        public String get() {
            return "settings.ban-evading.Enabled";
        }
    },
    BAN_EVADING_NOTIFY_TYPE {
        @Override
        public String get() {
            return "settings.ban-evading.notify.type";
        }
    },
    BAN_EVADING_NOTIFY_MESSAGE {
        @Override
        public String get() {
            return "settings.ban-evading.notify.message";
        }
    },
    BAN_EVADING_COMMAND {
        @Override
        public String get() {
            return "settings.ban-evading.cmd";
        }
    },
    GO_TO_ENABLED {
        @Override
        public String get() {
            return "settings.go-to.Enabled";
        }
    },
    GO_TO_MESSAGE {
        @Override
        public String get() {
            return "settings.go-to.message";
        }
    },
    GO_TO_BLOCKED_SERVERS {
        @Override
        public String get() {
            return "settings.go-to.blocked-server";
        }
    },
    GO_TO_PERMISSION {
        @Override
        public String get() {
            return "settings.go-to.permission";
        }
    },
    REPORTS_ACCEPT_PERMISSION {
        @Override
        public String get() {
            return "settings.reports.accept.permission";
        }
    },
    REPORTS_ACCEPT_MESSAGE {
        @Override
        public String get() {
            return "settings.reports.accept.message";
        }
    },
    REPORTS_ACCEPT_NOTIFY_ENABLED {
        @Override
        public String get() {
            return "settings.reports.accept.notify.Enabled";
        }
    },
    REPORTS_ACCEPT_NOTIFY_MESSAGE {
        @Override
        public String get() {
            return "settings.reports.accept.notify.message";
        }
    },
    REPORTS_DENY_PERMISSION {
        @Override
        public String get() {
            return "settings.reports.deny.permission";
        }
    },
    REPORTS_DENY_MESSAGE {
        @Override
        public String get() {
            return "settings.reports.deny.message";
        }
    },
    REPORTS_DENY_NOTIFY_ENABLED {
        @Override
        public String get() {
            return "settings.reports.deny.notify.Enabled";
        }
    },
    REPORTS_DENY_NOTIFY_MESSAGE {
        @Override
        public String get() {
            return "settings.reports.deny.notify.message";
        }
    }
}
