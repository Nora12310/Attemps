package org.akd.support.model

interface IFlexibleItem {
    fun areItemsTheSame(iFlexibleItem: IFlexibleItem): Boolean
    fun areContentsTheSame(iFlexibleItem: IFlexibleItem): Boolean
}
