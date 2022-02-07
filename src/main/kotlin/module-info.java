module tournamentFx {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires tornadofx;
    requires kotlin.stdlib;
    requires kotlin.reflect;
    requires java.desktop;
    requires java.json;
//    requires java.sql;
    exports nl.hilgenbos.tournamentfx.app to javafx.graphics, tornadofx;
    exports nl.hilgenbos.tournamentfx.view to javafx.graphics,tornadofx;
    exports nl.hilgenbos.tournamentfx.controller to javafx.graphics,tornadofx;
    exports nl.hilgenbos.tournamentfx.model to kotlin.reflect, tornadofx;
    opens nl.hilgenbos.tournamentfx.view;
}