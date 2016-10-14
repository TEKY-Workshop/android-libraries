Step 4
===

Goal
---

Add loading dialog to show user that work is being done.

Steps
---

* Add the [Material Dialogs](https://github.com/afollestad/material-dialogs) library via Gradle
* When starting the image load, create an [Indeterminate Progress Dialog](https://github.com/afollestad/material-dialogs#indeterminate-progress-dialogs).
  * Make sure to make the dialog undismissable
* When the image successfully loads, hide the dialog. If there was an error, show an error dialog.