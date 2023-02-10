package ru.sharanov.pastebox.service;

import ru.sharanov.pastebox.api.request.PasteBoxRequest;
import ru.sharanov.pastebox.api.responce.PasteBoxResponce;
import ru.sharanov.pastebox.api.responce.PasteBoxUrlResponce;

import java.util.List;

public interface PasteBoxService {
    PasteBoxResponce getByHash(String hash);
    List<PasteBoxResponce> getFirstPublicPasteBox(int amount);
    PasteBoxUrlResponce create(PasteBoxRequest request);
}
