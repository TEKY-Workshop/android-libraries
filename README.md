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

<img src="https://lh3.googleusercontent.com/OdhbTJwas7fZSHDxDV8J_ozfQNnB3IqngPxMFG6qh3PpuZ0Qj-HhNamoK5B7hjE72N9lc1-NyCCqKEAEhWb8XX-OsHc_ZMf7OpMSObo1lHKzSF8fHYmFiFlp4HYWcQx4Ru0C9rTsY1QoZAK8_gPJATTt7DKKxlsAvkehzzxEy7BqxkLJwwxWHtlca8oIgybmoU9neHdwhZBT_4PpZuHyrQ5qh6nRmbWTKl8J3ESVlqEEv0ZYRVLjfm14HjgHEJxrOAdyxEgRWnd08v5tWfAOwKNlPD63X2MrLIAPqYPLsh76cOPi5lhbOs3a5tovm836fDG0GOalhko0G9rW6ewIb3z40n438wqqrtY8yfl0mSE3QDrYrVX6onugjeIusRtUcMMg9KEyeSlCE40qvZHE5OcpkIr7TnS6UFHDQeIu6NTi_FVPDcTT64k2CQQx2u5QHb5hasD5hY82lhkUQ4ZKxBwJN8Ng_FFXPWsN7aN4Q5Cg0pXyyY-43YctRZkcD7o-zMPla45IHkVeOmcbA7tEx_j9W0S63FtrR3ydTNLcxp0OZTuorqj4PjfvdS0c2zVz199zsaWP_k76wNh2QSsmSQbWciH51KHurS2SdRWJOKZX6EtZ2A=w480-h847-no" alt="Final Product" style="width: 300px;" />
