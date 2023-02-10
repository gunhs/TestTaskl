package ru.sharanov.pastebox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.sharanov.pastebox.api.request.PasteBoxRequest;
import ru.sharanov.pastebox.api.request.PublicStatus;
import ru.sharanov.pastebox.api.responce.PasteBoxResponce;
import ru.sharanov.pastebox.api.responce.PasteBoxUrlResponce;
import ru.sharanov.pastebox.repository.PasteBoxEntity;
import ru.sharanov.pastebox.repository.PasteBoxRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
public class PasteBoxServiceImpl implements PasteBoxService {

    private String host;
    private int publicListSize;

    private final PasteBoxRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public PasteBoxResponce getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = repository.getByHash(hash);
        return new PasteBoxResponce(pasteBoxEntity.getData(), pasteBoxEntity.isPublic());
    }

    @Override
    public List<PasteBoxResponce> getFirstPublicPasteBox(int amount) {
        return null;
    }

    @Override
    public PasteBoxUrlResponce create(PasteBoxRequest request) {
        int hash = generateId();
        PasteBoxEntity pasteBoxEntity = new PasteBoxEntity();
        pasteBoxEntity.setData(request.getData());
        pasteBoxEntity.setId(hash);
        pasteBoxEntity.setHash(Integer.toHexString(hash));
        pasteBoxEntity.setPublic(request.getPublicStatus()== PublicStatus.PUBLIC);
        repository.add(pasteBoxEntity);
        return new PasteBoxUrlResponce(host+"/"+pasteBoxEntity.getHash());
    }

    private int generateId() {
        return idGenerator.getAndIncrement();
    }
}
