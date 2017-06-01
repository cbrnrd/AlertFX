/**
 * AlertFX generalizes the common types of Dialogs and Alerts in JavaFX.
 * The minimal effort message box looks like so:
 * <pre><code>
 *     MsgBox msgBox = new MsgBox("Message");
 *     msgBox.show();
 * </code></pre>
 * That's it!
 * <p></p>
 * Custom CSS can be applied to any alert with <code>applyCss("path")</code> where "path" is the path to your CSS file.
 * Be sure that your css sets styles for <code>DialogPane</code> or it will not work!
 */
package org.cbrnrd.alertfx;