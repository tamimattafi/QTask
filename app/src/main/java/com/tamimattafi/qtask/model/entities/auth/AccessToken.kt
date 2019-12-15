package com.tamimattafi.qtask.model.entities.auth

import com.tamimattafi.mvp.MvpBaseContract
import com.vk.api.sdk.auth.VKAccessToken

data class AccessToken(
    override val value: String,
    val userId: Long
) : MvpBaseContract.Token {

    constructor(vkToken: VKAccessToken) : this(vkToken.accessToken, vkToken.userId!!.toLong())


}
