var cancellable = function(generator) {
    let cancel;
    const cancelPromise = new Promise((_, reject) => {
        cancel = () => reject("Cancelled");
    });

    const promise = (async () => {
        let next = generator.next();
        while (!next.done) {
            try {
                const value = await Promise.race([next.value, cancelPromise]);
                next = generator.next(value);
            } catch (err) {
                next = generator.throw(err);
            }
        }
        return next.value;
    })();

    return [cancel, promise];
};
