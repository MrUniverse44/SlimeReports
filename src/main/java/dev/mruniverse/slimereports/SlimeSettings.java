package dev.mruniverse.slimereports;

@SuppressWarnings("unused")
public enum SlimeSettings implements SlimeSetting {
    BAN_EVADING_ENABLED("settings.ban-evading.enabled"),
    BAN_EVADING_NOTIFY_TYPE("settings.ban-evading.notify.type"),
    BAN_EVADING_NOTIFY_MESSAGE("settings.ban-evading.notify.message"),
    BAN_EVADING_COMMAND("settings.ban-evading.command"),
    GO_TO_ENABLED("settings.go-to.enabled"),
    GO_TO_MESSAGE("settings.go-to.message"),
    GO_TO_BLOCKED_SERVERS("settings.go-to.blocked-server"),
    GO_TO_PERMISSION("settings.go-to.permission"),
    REPORTS_ACCEPT_PERMISSION("settings.reports.accept.permission"),
    REPORTS_ACCEPT_MESSAGE("settings.reports.accept.message"),
    REPORTS_ACCEPT_NOTIFY_ENABLED("settings.reports.accept.notify.enabled"),
    REPORTS_ACCEPT_NOTIFY_MESSAGE("settings.reports.accept.notify.message"),
    REPORTS_DENY_PERMISSION("settings.reports.deny.permission"),
    REPORTS_DENY_MESSAGE("settings.reports.deny.message"),
    REPORTS_DENY_NOTIFY_ENABLED("settings.reports.deny.notify.enabled"),
    REPORTS_DENY_NOTIFY_MESSAGE("settings.reports.deny.notify.message");

    private final String path;

    SlimeSettings(String path) {
        this.path = path;
    }

    @Override
    public String get() {
        return this.path;
    }
}
