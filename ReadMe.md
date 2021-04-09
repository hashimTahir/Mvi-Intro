# Dictionay App

Very Minimal Implementation of MVI, Almost no Ui.
Dependency injection ----Dagger-Hilt,
Coroutines


### Architecture
## MVI-Model View Intent
The Model-View-Intent comprises of a Model, View, and Presenter. Intent in this
architecture doesn’t stand for a component, nor does it refer to the Intent object
from the Android SDK. Rather, it stands for a desire to perform an action.
A use-case if you will. An intent.

MVI differs from the other patterns that the Presenter only ever sends one object to the View,
commonly referred as a View State. The View State is meant to carry all the information
the View needs to render itself. The Presenter can update the View State as it fetches
new data, but the View receives no other data from the Presenter than this one View State.
## It strictly adheres to the Single-Source-of-Truth (SSOT) programming principle.

Thus, an Intent in this case refers to a complete flow of actions, from the Presenter asking
the Model to retrieve data, to updating the View State, to passing the updated View State
to the View for rendering. This intent can be started from the presenter’s creation,
or result from a user interaction such as button click, and when the View successfully
renders itself from an updated View State, the intent is resolved.

This carries the obvious advantage of having only a single object to observe,
thus managing running tasks becomes easier than it could ever be.

The knowledge structure is the same as that of MVP, as this could be seen as an enhancement
to the MVP architecture.

This ‘enhancement’ isn’t without consequences though. How does the Presenter handle
updating the View State with new data while gracefully keeping the data it already contains?
The answer to this is another concept of the MVI pattern called State Reducers.
These are objects that handle the merging of new data with the existing View State, and are
 derived from a timeless programming concept of the same name.

In more complex activities, the complexity of the reducer scales along with it and can
very quickly become an object requiring high skill to maintain, and even higher skill
to create properly.

