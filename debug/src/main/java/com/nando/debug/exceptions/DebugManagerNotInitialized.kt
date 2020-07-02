package com.nando.debug.exceptions

import java.lang.Exception

class DebugManagerNotInitialized: Exception("The DebugManager was not initialized, please make sure to initialize it by calling DebugManager.init() with the debugger settings") {
}