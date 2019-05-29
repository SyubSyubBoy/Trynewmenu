package com.tailors.trynewmenu.domain;

public interface DomainDto<T extends DomainEntity> {
    T toEntity();
}
