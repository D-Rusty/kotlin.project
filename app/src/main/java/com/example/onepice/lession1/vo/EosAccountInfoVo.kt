package com.example.onepice.lession1.vo

/**
 * Created by onepice on 2018-12-19
 */
data class EosAccountInfoVo(
    var creator: String,
    var create_timestamp: String,
    var permissions: List<Permissions>
) {
    data class Permissions(
        var perm_name: String,
        var parent: String,
        var required_auth: RequiredAuth
    ) {
        data class RequiredAuth(
            var threshold: Int,
            var keys: List<Keys>,
            var accounts: List<Accounts>,
            var waits: List<Int>
        ) {
            data class Keys(
                var key: String,
                var weight: Int
            )

            data class Accounts(
                var permission: Permission,
                var weight: Int
            ) {
                data class Permission(
                    var actor: String,
                    var permission: String
                )
            }
        }
    }
}