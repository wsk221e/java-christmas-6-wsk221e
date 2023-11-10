package christmas.domain;

public enum Badges {
    별(5_000),
    트리(10_000),
    산타(20_000);

    private int benefit;

    Badges(int benefit) {
        this.benefit = benefit;
    }

    public static String getBadgeByBenefit(int benefit) {
        String highest = "";
        for (Badges badge : Badges.values()) {
            if (benefit >= badge.benefit) {
                highest = badge.toString();
            }
            if (benefit < badge.benefit) {
                break;
            }
        }
        return highest;
    }

}
