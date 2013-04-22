package com.unexpected.ant.proto;

public interface CommandResolver {
	Command resolve(String line) throws CommandNotFoundException;
}
