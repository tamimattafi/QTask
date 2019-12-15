package com.tamimattafi.qtask.model.client

object ClientValues {

    object Paths {

        const val BASE_LINK = "http://tasker.evtn.ru/api/"
        const val TASKS = "tasks"
        const val MEMBERS = "members"
        const val INVITATIONS = "invite"

        object Actions {

            object Tasks {
                const val CREATE = "create"
                const val EDIT = "edit"
                const val GET_ONE = "get"
                const val OWNER = "owner"
                const val GET_ALL = "retrieve"
                const val LEAVE = "leave"
                const val IMPORTANT = "important"
            }

            object Members {
                const val EDIT = "edit"
            }

            object Invitations {
                const val ACCEPT = "accept"
                const val DECLINE = "decline"
            }

        }
    }


    object Query {
        object Params {
            const val USER = "user"
        }
    }

}