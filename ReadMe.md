# Dictionay App

### Architecture
## MVI-Model View Intent
 Everything the view requires is packeged into a single class "ViewState" as
 single source of truth and view observes the change in the data.
 StateEvents are fired from the view as intents i.e. what users wants to do towards
 viewmodel.


###Technologies Used
Dagger-Hilt
Retrofit
Merriam-Webster's Dictionary Api
Oxford Dictionary Api
Coroutines
Navigation Components
