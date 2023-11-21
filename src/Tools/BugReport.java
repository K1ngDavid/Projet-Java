package Tools;

import java.lang.annotation.*;

public @interface BugReport {
    String[] reportedBy() default {"codeur masqué"};
    String description() default "ça ne marche pas !";
    PRIORITY priority() default PRIORITY.LOW;
    STATUS status() default STATUS.NOT_FIXED;

    enum PRIORITY {
        HIGH, MEDIUM, LOW
    }

    enum STATUS {
        FIXED, IN_PROGRESS, NOT_FIXED
    }
}
