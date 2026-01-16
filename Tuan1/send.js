const ampq = require('amqplib')
const send = async () => {
    const connection = await ampq.connect('amqp://127.0.0.1');
    const channel = await connection.createChannel();
    const queue = 'chat_queue';
    await channel.assertQueue(queue);
    const msg = {
        user: "Thang",
        message: "Hello World",
        time: new Date()
    }
    channel.sendToQueue(queue, Buffer.from(JSON.stringify(msg)));
    console.log('Message sent:', msg);
    setTimeout(() => {
        connection.close();
        process.exit(0);
    }, 500);
}
send()