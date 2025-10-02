package org.example.apimain.account.utils;

import org.example.apimain.account.DTO.AccountDTO;
import org.example.apimain.account.entities.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper  {
    AccountEntity toEntity(AccountDTO accountDTO);
}