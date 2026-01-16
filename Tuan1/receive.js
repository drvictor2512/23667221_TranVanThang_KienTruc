const ampq = require('amqplib')
const recieve = async () => {
    const connection = await ampq.connect('amqp://127.0.0.1');
    const channel = await connection.createChannel();
    const queue = 'chat_queue';
    await channel.assertQueue(queue);
    console.log('Waiting for messages...');
    channel.consume(queue, (msg) => {
        const data = JSON.parse(msg.content.toString());
        console.log('New message:', data.user, ":", data.message);

    })
}
recieve()