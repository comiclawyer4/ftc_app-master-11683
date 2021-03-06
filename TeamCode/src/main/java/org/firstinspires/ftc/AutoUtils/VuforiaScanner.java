package org.firstinspires.ftc.AutoUtils;

import org.firstinspires.ftc.bot.TestBedBot;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.utils.Vuforia;

public class VuforiaScanner {

    TestBedBot bot = new TestBedBot();
    private Vuforia vuforia;
    private VuforiaTrackable relicTemplate;
    RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

    public void initialize()
    {
        bot = new TestBedBot();
        vuforia = new Vuforia(bot.hardwareMap);
        VuforiaTrackables relicTrackables = this.vuforia.localizer.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        relicTrackables.activate();
    }
    public RelicRecoveryVuMark getVuMark() {
        //UNKNOWN, LEFT, CENTER, RIGHT
        vuMark = RelicRecoveryVuMark.from(relicTemplate);
        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                /* Found an instance of the template. In the actual game, you will probably
                 * loop until this condition occurs, then move on to act accordingly depending
                 * on which VuMark was visible. */
                vuMark = RelicRecoveryVuMark.from(relicTemplate);
        } else {
            vuMark = RelicRecoveryVuMark.UNKNOWN;
        }
        return vuMark;
    }
}