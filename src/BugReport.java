import java.lang.annotation.*;

public @interface BugReport {
    String[] reportedBy() default {"codeur masqué"};
    String description() default "ça ne marche pas !";
    PRIORITE priorite() default PRIORITE.FAIBLE;

    enum PRIORITE {
        HAUTE, MOYENNE, FAIBLE
    }
}
