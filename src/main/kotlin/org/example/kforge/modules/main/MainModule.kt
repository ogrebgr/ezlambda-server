package com.bolyartech.totoproverka3.server.main

import com.bolyartech.forge.server.HttpMethod
import com.bolyartech.forge.server.module.HttpModule
import com.bolyartech.forge.server.route.Route
import com.bolyartech.forge.server.route.RouteImpl
import lalalambda.generic.AwsLambdaDispatcher
import org.example.kforge.modules.main.endpoints.AwsLambdaEp
import java.util.*

class MainModule constructor(private val dis: AwsLambdaDispatcher) : HttpModule {
    companion object {

        private const val MODULE_SYSTEM_NAME = "main"
        private const val MODULE_VERSION_CODE = 1
        private const val MODULE_VERSION_NAME = "1.0.0"
        private const val PATH_PREFIX = "/"
    }

    override fun createRoutes(): List<Route> {
        val ret = ArrayList<Route>()

        val ep = AwsLambdaEp(dis)
        ret.add(RouteImpl(HttpMethod.GET, PATH_PREFIX + "aws", ep))
        ret.add(RouteImpl(HttpMethod.POST, PATH_PREFIX + "aws", ep))
        ret.add(RouteImpl(HttpMethod.PUT, PATH_PREFIX + "aws", ep))
        ret.add(RouteImpl(HttpMethod.DELETE, PATH_PREFIX + "aws", ep))

        return ret
    }

    override fun getSystemName(): String {
        return MODULE_SYSTEM_NAME
    }

    override fun getShortDescription(): String {
        return ""
    }

    override fun getVersionCode(): Int {
        return MODULE_VERSION_CODE
    }

    override fun getVersionName(): String {
        return MODULE_VERSION_NAME
    }
}