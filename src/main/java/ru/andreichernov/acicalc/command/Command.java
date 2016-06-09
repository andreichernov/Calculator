package ru.andreichernov.acicalc.command;

import ru.andreichernov.acicalc.exception.InterruptOperationException;

interface Command
{
    void execute() throws InterruptOperationException;
}
