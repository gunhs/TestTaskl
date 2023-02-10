package ru.sharanov.pastebox.repository;

import java.util.List;

public interface PasteBoxRepository {
    PasteBoxEntity getByHash(String hash);
    List<PasteBoxEntity> getListPublicAndAlive (int amount);
    void add(PasteBoxEntity pasteBoxEntity);
}
