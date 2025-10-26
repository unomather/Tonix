package tonix.app.di

import tonix.app.app_shared.core_ui.di.moduleAppSharedCoreUi
import tonix.app.app_shared.ui.di.moduleAppSharedUi
import tonix.app.app_ui_small.di.moduleAppSmallUi

val appModules = buildList {
    add(moduleShared)
    add(moduleAppSharedCoreUi)
    add(moduleAppSharedUi)
    addAll(moduleAppSmallUi)
}