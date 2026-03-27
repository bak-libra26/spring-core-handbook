package com.example.core.di;
import org.springframework.stereotype.Service;
@Service
public class MessageService {
    public String getMessage() { return "Hello from injected service!"; }
}
