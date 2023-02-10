package ru.sharanov.pastebox.api.responce;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sharanov.pastebox.api.request.PublicStatus;

@Data
@RequiredArgsConstructor
public class PasteBoxResponce {
    private final String data;
    private final boolean isPublic;
}
